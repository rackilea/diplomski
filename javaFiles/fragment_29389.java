.progress-bar > .track {
      -fx-background-color: 
          -fx-shadow-highlight-color,
          linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),
          linear-gradient(to bottom, 
            derive(-fx-control-inner-background, -7%),
            derive(-fx-control-inner-background, 0%),
            derive(-fx-control-inner-background, -3%),
            derive(-fx-control-inner-background, -9%)
          );
    -fx-background-insets: 0, 0 0 1 0, 1 1 2 1;
    -fx-background-radius: 4, 3, 2; /* 10, 9, 8 */
}