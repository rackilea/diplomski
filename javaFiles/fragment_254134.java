public static void main(String[] args){
  PlannerMain planner = new PlannerMain();
  planner.frame = new JFrame("Land Planner");
  planner.makeMap = new JButton("Make Map");
  planner.makeMap.addActionListener(new makeMapListener());
  ...
}