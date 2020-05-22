@ExtendWith(MockitoExtension.class)
class Test {

    public static class ApprovalManagementDAO {

        public ApprovalManagementBean insertOrUpdateApprovalManagement(JSONArray arr, String transactionType)
                throws Exception {

            ApprovalManagementBean obj = new ApprovalManagementBean();
            JSONObject jsonObjInput;

            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                if (transactionType.equals("ADD")) {

                    connection = getConnectionFromAppsPro();
                    for (int i = 0; i < arr.length(); i++) {
                        jsonObjInput = arr.getJSONObject(i);

                        String query = "some insert query";
                        ps = connection.prepareStatement(query);

                        ps.setString(1, jsonObjInput.get("eitCode").toString());
                        ps.setString(2, !jsonObjInput.isNull("segementName") ? jsonObjInput.get("segementName").toString() : "");

                        ps.executeUpdate();

                    }

                } else if (transactionType.equals("EDIT")) {
                    connection = getConnectionFromAppsPro();
                    for (int i = 0; i < arr.length(); i++) {
                        jsonObjInput = arr.getJSONObject(i);
                        String query = "some update query";
                        ps = connection.prepareStatement(query);
                        ps.setString(1, !jsonObjInput.isNull("enable") ? jsonObjInput.get("enable").toString() : "");

                        ps.executeUpdate();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeResources(connection, ps, rs);
            }

            return obj;
        }

        private void closeResources(Connection connection, PreparedStatement ps, ResultSet rs) {
        }

        Connection getConnectionFromAppsPro() {
            return null;
        }
    }

    Connection mockConn;
    PreparedStatement mockPreparedStmnt;
    ApprovalManagementDAO approvalManagementDAO;

    @BeforeEach
    public void setUp() throws SQLException {

        mockConn = Mockito.mock(Connection.class);
        mockPreparedStmnt = Mockito.mock(PreparedStatement.class);

        Mockito.when(mockConn.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStmnt);

        approvalManagementDAO = new ApprovalManagementDAO() {

            @Override
            public Connection getConnectionFromAppsPro() {
                return mockConn;
            }
        };
    }

    @Test
    public void insertOrUpdateApprovalManagement() throws Exception {

        String transactionType = "ADD";

        JSONObject mockJsonObject = Mockito.mock(JSONObject.class);
        Mockito.when(mockJsonObject.get(Mockito.anyString())).thenReturn("");

        JSONArray mockJsonArray = Mockito.mock(JSONArray.class);
        Mockito.when(mockJsonArray.length()).thenReturn(1);
        Mockito.when(mockJsonArray.getJSONObject(0)).thenReturn(mockJsonObject);

        approvalManagementDAO.insertOrUpdateApprovalManagement(mockJsonArray, transactionType);
        Mockito.verify(mockConn, Mockito.times(1)).prepareStatement(Mockito.anyString());

        Mockito.verify(mockPreparedStmnt, Mockito.times(2)).setString(Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(mockPreparedStmnt, Mockito.times(1)).executeUpdate();

    }
}