String fromstr = etFrom.getText().toString();
try {
      double fromDouble = Double.parseDouble(fromstr);
} catch (NumberFormatException e) {
    System.out.println(fromstr)
}