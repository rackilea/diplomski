public class TestLayout extends Composite {

private static TestLayoutUiBinder uiBinder = GWT
        .create(TestLayoutUiBinder.class);

interface TestLayoutUiBinder extends UiBinder<Widget, TestLayout> {
}

public TestLayout() {
    initWidget(uiBinder.createAndBindUi(this));
    headerPanel.add(new Label("Head!"));
    leftPanel.add(new Label("Left!"));
    menuPanel.add(new Label("Menu!"));
    contentPanel.add(new Label("Content!"));
}

@UiField
FlowPanel headerPanel;

@UiField
FlowPanel leftPanel;

@UiField
FlowPanel menuPanel;

@UiField
FlowPanel contentPanel;
}