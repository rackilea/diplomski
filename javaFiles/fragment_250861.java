// Moved outside
PreparedStatement pstmt=null;

// Using the question mark as a placeholder for a variable
pstmt = conn.prepareStatement("INSERT INTO DUMMY (ID) VALUES (?)");

for (int i = 1; i < 5000; i++) {

    try {
        //Deliberate error on the SQL (Primary Key Constraint)
        // Only set the variable in the loop
        pstmt.setInt(1, i);
        pstmt.executeUpdate();

    } catch (Exception e) {
        System.err.println("DB Error on iteration "+i+": " + 
                    e.getMessage());
        //If I add the following line then I can close the error!
        //try {pstmt.close();} catch (Exception e1) {} 
    }    
}
pstmt.close();  // Moved out of loop