try {
   enemyHit();
} catch (Exception e) {
    System.out.print("RuntimeException: ");
    System.out.println(e.getMessage());
    e.printStackTrace();
}