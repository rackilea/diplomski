switch (c_a.getText()) {
    case "Customer": {
        new LoginPage().setVisible(true);
        break;
    }
    case "Admin": {
        new LoginPageadmin().setVisible(true);
        break;
    }
    default: {
        JOptionPane.showMessageDialog(this, "Please try again");
        break;
    }
}