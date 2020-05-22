int value;
if ("-".equals(points_player)) {
    value = 0; // No points, yet
} else {
    value = Integer.parseInt(points_player);
}

System.out.println(value);