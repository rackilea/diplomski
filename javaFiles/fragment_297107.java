try { 
     e = (Employee) in.readObject();   //Possibility of exception 
  } catch(IOException i) { 

  } catch(ClassNotFoundException c) { 

  } finally {
     in.close();
     fileIn.close();
  }