ActionListener myActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            DatabaseConnection connection = new DatabaseConnection();
            PreparedStatement preparedStatement = null;
            if (connection.openConnection())
            {
                String ID = input1.getText();
                int orderID = Integer.parseInt(ID);

                String firstName = (String) cb.getSelectedItem();
                System.out.println(firstName);
                System.out.println(orderID);
                if (firstName == "Patrick")
                {
                    int employeeId = 10;

                    String sql = "UPDATE barorder SET statusId=2, employeeId= ? where id= ?";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, employeeId);
                    preparedStatement.setInt(2, orderID);
                    preparedStatement.executeUpdate(sql);

                }

            }
        }
    };