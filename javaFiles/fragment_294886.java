@Override
public String generateToolTip(XYDataset arg0, int arg1, int arg2) {
    return String.format(
            "<html><body><img src='%s'> some data </body></html>",
            getClass().getResource("/images/duke.gif"));
}