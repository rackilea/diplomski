package za.co.bsg.ems.client.framework.ui.slider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import za.co.bsg.ems.client.event.IntegerValueChangeEvent;

import java.util.HashSet;
import java.util.Set;

public class PercentageSliderWidget extends Composite implements SliderListener, HasValueChangeHandlers<Integer> {

    interface PercentageSliderUiBinder extends UiBinder<Widget, PercentageSliderWidget> {}
    private static final PercentageSliderUiBinder UI_BINDER = GWT.create(PercentageSliderUiBinder.class);

    @UiField
    Label headingLabel;
    @UiField(provided = true)
    SingleSlider singleSlider;
    @UiField
    IntegerBox percentBox;
    @UiField
    Label percentageSignLabel;

    private Set<ValueChangeHandler<Integer>> valueChangeHandlers;

    public PercentageSliderWidget(long taskId, String heading, int existingProgress) {
        valueChangeHandlers = new HashSet<>();
        JSONObject options = SingleSlider.getOptions(0, 100, existingProgress);
        singleSlider = new SingleSlider("singleSlider" + taskId, options);
        singleSlider.setTitle(existingProgress + "%");
        initWidget(UI_BINDER.createAndBindUi(this));
        singleSlider.addListener(this);
        percentBox.setValue(existingProgress);
        percentBox.addValueChangeHandler(new ValueChangeHandler<Integer>() {
            @Override
            public void onValueChange(ValueChangeEvent<Integer> event) {
                updateValues(event.getValue(), true);
            }
        });
        headingLabel.setText(heading);
        percentageSignLabel.setText("%");
    }

    public void setValue(int value) {
        updateValues(value, false);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Integer> handler) {
        valueChangeHandlers.add(handler);
        return new HandlerRegistration() {
            @Override
            public void removeHandler() {
                valueChangeHandlers.remove(handler);
            }
        };
    }

    @Override
    public boolean onSlide(SliderEvent e) {
        percentBox.setValue(e.getValue());
        return true;
    }

    @Override
    public void onChange(SliderEvent e) {
        // do nothing
    }

    @Override
    public void onStop(SliderEvent e) {
        updateValues(e.getValue(), true);
    }

    @Override
    public void onStart(SliderEvent e) {
        // do nothing
    }

    private void updateValues(int progressValue, boolean fireEvents) {
        singleSlider.setTitle(progressValue + "%");
        singleSlider.setValue(progressValue);
        percentBox.setValue(progressValue);
        if (fireEvents) {
            for (ValueChangeHandler<Integer> valueChangeHandler : valueChangeHandlers) {
                valueChangeHandler.onValueChange(new IntegerValueChangeEvent(progressValue));
            }
        }
    }

}