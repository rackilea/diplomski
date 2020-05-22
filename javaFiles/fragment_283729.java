if (set.next() == false) {  // ***** here on this line
        JOptionPane.showMessageDialog(null, "No Matchs found for the search query! 
            Try Again.", "Search Error", JOptionPane.ERROR_MESSAGE);
    } else {
        while (set.next()) {
            System.out.print(set.getString("dept_name"));
            txtName.setText(set.getString("dept_name"));
            txtDes.setText(set.getString("dept_desc"));
        }
    }