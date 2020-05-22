package mediaviewlayout;
import javafx.beans.NamedArg;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

public class MediaViewLayout extends Pane {

    private final MediaView mediaView ;
    private final Node content ;

    private static final double SPACING = 5 ; // can make this configurable if needed...

    public MediaViewLayout(
            @NamedArg("mediaView") MediaView mediaView,
            @NamedArg("content") Node content) {

        this.mediaView = mediaView ;
        this.content = content ;

        this.getChildren().addAll(mediaView, content);
    }

    @Override
    public double computeMinWidth(double height) {
        return Math.max(mediaView.minWidth(height), content.minWidth(height));
    }

    @Override
    public double computePrefWidth(double height) {
        return Math.max(mediaView.prefWidth(height), content.prefWidth(height));
    }

    @Override
    public double computeMaxWidth(double height) {
        return Math.min(mediaView.maxWidth(height), content.maxWidth(height));
    }

    @Override
    public double computeMinHeight(double width) {
        return mediaView.minHeight(width) + content.minHeight(width) + SPACING ;
    }

    @Override
    public double computePrefHeight(double width) {
        return mediaView.prefHeight(width) + content.prefHeight(width) + SPACING ;
    }

    @Override
    public double computeMaxHeight(double width) {
        return mediaView.maxHeight(width) + content.minHeight(width) + SPACING ;
    }

    @Override
    protected void layoutChildren() {
        double width = getWidth();
        double height = getHeight();
        double contentHeight = content.prefHeight(-1);
        double availableHeight = height - SPACING - contentHeight ;
        mediaView.setFitWidth(width);
        mediaView.setFitHeight(availableHeight);
        Bounds actualMediaBounds = mediaView.getBoundsInLocal();
        double totalUsedHeight = actualMediaBounds.getHeight() + SPACING + contentHeight ;

        double mediaX = (width - actualMediaBounds.getWidth()) / 2 ;
        double mediaY = (height - totalUsedHeight) / 2;
        mediaView.relocate(mediaX, mediaY);

        content.resizeRelocate(0, mediaY+actualMediaBounds.getHeight()+SPACING, width, contentHeight);

    }
}