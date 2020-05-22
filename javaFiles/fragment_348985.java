public void close() {
    try {
        try {
            try {
                try {
                    // This is empty due to the first line in `CompositeCloseable`'s constructor
                } finally {
                    stream.close();
                }
            } finally {
                resultSet.close();
            }
        } finally {
            preparedStatement.close();
        }
    } finally {
        connection.close();
    }
}