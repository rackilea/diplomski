public class SequenceMapperTest extends MyBatisTestBase {
    private final SqlSessionManager sessionManager;
    private final SequenceMapper sequenceMapper;

    @Factory(dataProvider = "sql-session-manager-provider")
    public SequenceMapperTest(SqlSessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.sequenceMapper = sessionManager.getMapper(SequenceMapper.class);
    }

    @Test
    public void selectBidSequenceTest() {
        sequenceMapper.selectSequence(Sequences.BID_SEQ);
    }

    @Test
    public void updateBidSequenceTest() {
        sequenceMapper.updateSequence(sequenceMapper.selectSequence(Sequences.BID_SEQ));
    }

    @Override
    public SqlSessionManager getSessionManager() {
        return this.sessionManager;
    }
}