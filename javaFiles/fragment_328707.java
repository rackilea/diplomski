public class ABeanAdapterImpl extends XmlAdapter<ABeanRef, Abean> {

        private ABeanAdapterList listAdapter;

        public ABeanAdapterImpl(ABeanAdapterList list) {
            listAdapter = list;
        }

        @Override
        public Abean unmarshal(ABeanRef wrapper) throws Exception {
            return listAdapter.getAbean(wrapper.refId);
        }

        @Override
        public ABeanRef marshal(Abean abean) throws Exception {
            ABeanRef ref = new ABeanRef();
            ref.refId = listAdapter.getId(abean);
            return ref;

        }
    }