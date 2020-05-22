-fx-inner-border: linear-gradient(to bottom,
                ladder(
                    -fx-color,
                    derive(-fx-color,30%) 0%,
                    derive(-fx-color,20%) 40%,
                    derive(-fx-color,25%) 60%,
                    derive(-fx-color,55%) 80%,
                    derive(-fx-color,55%) 90%,
                    derive(-fx-color,75%) 100%
                ),
                ladder(
                    -fx-color,
                    derive(-fx-color,20%) 0%,
                    derive(-fx-color,10%) 20%,
                    derive(-fx-color,5%) 40%,
                    derive(-fx-color,-2%) 60%,
                    derive(-fx-color,-5%) 100%
                ));

-fx-body-color: linear-gradient(to bottom,
            ladder(
                -fx-color,
                derive(-fx-color,8%) 75%,
                derive(-fx-color,10%) 80%
            ),
            derive(-fx-color,-8%));