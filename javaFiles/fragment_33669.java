@Repository
public enum SummaryDao implements IGeneralDao {
    Category {
        @Override
        public Summary callReports(RequestDto requestDto) {
            return ...;
        }
    },
    Group {
        @Override
        public Summary callReports(RequestDto requestDto) {
            return ...;
        }
    },
    SubGroup {
        @Override
        public Summary callReports(RequestDto requestDto) {
            return ...;
        }
    };

    @Override
    public IGenericDao setEnumType(EnumType type) {
        return valueOf(type.name());
    }
}