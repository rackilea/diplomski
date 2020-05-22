@Repository
public enum ReportDao implements IGeneralDao {
    Category {
        @Override
        public List<Response> callReports(RequestDto requestDto) {
            return ...;
        }
    },
    Group {
        @Override
        public List<Response> callReports(RequestDto requestDto) {
            return ...;
        }
    },
    SubGroup {
        @Override
        public List<Response> callReports(RequestDto requestDto) {
            return ...;
        }
    };

    @Override
    public IGenericDao setEnumType(EnumType type) {
        return valueOf(type.name());
    }
}