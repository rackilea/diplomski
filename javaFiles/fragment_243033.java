@Override
    public Class<?> getColumnClass(int colNum) {
        switch (colNum) {
            case 0:
                return Integer.class;
            case 1:
                return Double.class;
            case 2:
                return Long.class;
            case 3:
                return Boolean.class;
            case 4:
                return String.class;
            case 5:
                return Icon.class;
            default:
                return String.class;
        }
    }