public void keyReleased(KeyEvent e) {
    if (e.keyCode == SWT.CR)
            System.out.println("Success");
        else
            System.out.println("Not Yet");
    }
}