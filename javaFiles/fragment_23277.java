@Test
public void cloning() {
    Student original = new Student(....); // 
    ...
    Student cloned = original.clone();
    // deep check
    assertEquals(original.getDob(), cloned.getDob());
    assertEquals(original.getAddress(), cloned.getAddress());
    assertNotSame(original.getDob(), cloned.getDob());
    assertNotSame(original.getAddress(), cloned.getAddress());

   // shallow check    
   assertSame(original.getCourse(), cloned.getCourse());
}