try {
    Class courseOne = Class.forName("com.fastnuces.keepmeposted.courseone");
    Intent CourseOneScr = new Intent(HomePageActivity.this, courseOne);
    startActivity(CourseOneScr);  
} catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}