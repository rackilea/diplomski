interface Row {
    void setDouble(double d);
    double getDouble();

    void setString(@MaxUtf8Length(8) String s);
    String getString();
}