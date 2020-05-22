public static void main(String[] args) {
    J48TreeWrapper wrapper = new J48TreeWrapper(new J48Tree());
    Visualization visualization = new Visualization();
    visualization.setGraphable(wrapper);
    visualization.graph();
}