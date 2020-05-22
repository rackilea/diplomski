@Override
public Class<?> getColumnClass(int columnIndex) {
    Class type = String.class;
    switch (columnIndex) {
        case 0:
            type = Integer.class;
            break;
        case 1:
            type = Boolean.class;
            break;
    }
    return type;
}