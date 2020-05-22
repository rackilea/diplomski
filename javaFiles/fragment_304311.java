spinner.getEditor().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    System.out.println("++1");
                    spinner.increment(1);
                    break;
                case DOWN:
                    System.out.println("--1");
                    spinner.decrement(1);
                    break;
            }
        });