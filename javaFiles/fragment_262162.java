List<Color> colors = Arrays.stream(Color.class.getFields())
        // fields of type Color, and in all caps, snake case
        .filter(x -> x.getType() == Color.class && x.getName().matches("[A-Z_]+"))
        .map(x -> {
            try {
                return (Color)x.get(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return Color.BLACK;
            }
        }).collect(Collectors.toList());