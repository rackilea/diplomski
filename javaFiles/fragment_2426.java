public Object getValueAt(int row, int column) {
            Object value = valueAt(row, column);

            if (value != null
                    && (value.toString().equals("0") || value.toString()
                            .equals("0.0")|| value.toString().equals("default"))) {
                return null;
            }

            return value;
        }