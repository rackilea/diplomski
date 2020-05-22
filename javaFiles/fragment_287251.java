private void jButton8ActionPerformed(java.awt.event.ActionEvent evt)                                         
{                                             
    criteriaModel.loadCodeBase();
    int choice = JOptionPane.showConfirmDialog(this,
         "Are you sure you want to submit your search criteria and exit the \"Customise Search Criteria\" web page?",
         "Confirm Submit",
         JOptionPane.YES_NO_OPTION,
         JOptionPane.QUESTION_MESSAGE);

     if (choice == 0)
     {
         try 
         {      
             URL url = new URL(criteriaModel.getCodeBase(), "CriteriaServlet");

             System.out.println("Servlet address is: " + url);

            Object searchSubmitObject = criteriaModel.getObjectSlideData();

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/x-java-serialized-object");

            ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
            out.writeObject(searchSubmitObject);
            out.flush();
            out.close();
            out.close();

            System.out.println("Object Written");

            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            String response = (String)in.readObject();
            System.out.println(response);
            in.close();

            if(response.equals("Failed"))
            {
                JOptionPane.showMessageDialog(jPanel8, "Submit Search criteria file to server failed.\n Try Again later.");
            }
            else
            {
                getAppletContext().showDocument(new URL("javascript:openResultsPage()"));
            }
         } 
         catch (MalformedURLException ex)
        {
            JOptionPane.showMessageDialog(jPanel8, "Submit criteria file Malformed URL."
                    + ex.toString());
            System.out.println("MalformedURLException occurred");
            Logger.getLogger(CriteriaInterfaceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e) 
         {
             System.out.println("Submit criteria file ERROR exception: " + e.toString());
             JOptionPane.showMessageDialog(jPanel8, "Submit criteria file ERROR exception:"
                    + e.toString());
         }
     }         
}