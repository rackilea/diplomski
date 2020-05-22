.fxdialog { 
    -fx-background-color:linear-gradient(white,#DDDDDD);
    -fx-border-radius: 20;
    -fx-border-color: transparent;
    -fx-padding: 10 10 10 10;
    -fx-background-radius: 20;
}
.fxdialog-root {
    -fx-background-color: transparent;
}
.fxdialog-header {
    -fx-alignment: center;
    -fx-text-aligment: center;
    -fx-text-fill: white;
    -fx-font: 32px bold;
    -fx-background-color: black;
    -fx-background-insets: 0 -11 0 -11;
}
.ERROR       .fxdialog-header {-fx-background-color: red;}
.INFORMATION .fxdialog-header {-fx-background-color: blue;}
.WARNING     .fxdialog-header {-fx-background-color: orange;}
.QUESTION    .fxdialog-header {-fx-background-color: gold;}
.fxdialog-message {
    -fx-font-size: 18px;
}
.button {
    -fx-font-size: 12px;
}
.combo-box .list-view .list-cell {
    -fx-background-color: rgba(33, 248, 33, .4);
    -fx-accent: derive(-fx-control-inner-background, -40%);
}
.combo-box .list-view .list-cell:busy {
    -fx-graphic: url("icons/link.png");
    -fx-background-color: rgba(255, 248, 33, .4);
    -fx-accent: derive(-fx-control-inner-background, -40%);
}