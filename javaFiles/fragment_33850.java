MockUp<PmRequestData> mockpmreq = new MockUp<PmRequestData>() {
        @Mock
        public Map<String, KPIData> getKpiDataMap() {
            return datamap;
            }
        };
mockpmreq.tearDown();