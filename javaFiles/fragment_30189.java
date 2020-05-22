if (car2.y + 200 < 0) {
            iter.remove();
            score++;

            if (car.overlaps(car2)) {
                System.out.println("Works");
                iter.remove();

            }
        }