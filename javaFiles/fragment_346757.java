List<SaleAggrData> salesAggrData =
    saleData.parallelStream()
            .map(data -> {
                    SaleAggrData saleAggrData = new SaleAggrData() {
                        {
                            setCatId(data.getCatId());
                            setRevenue(RoundUpUtil.roundUpDouble(data.getRevenue()));
                            setMargin(RoundUpUtil.roundUpDouble(data.getMargin()));
                            setUnits(data.getUnits());
                            setMarginRate(ComputeUtil.marginRate(data.getRevenue(), data.getMargin()));
                            setOtd(ComputeUtil.OTD(data.getRevenue(), data.getUnits()));
                            setSaleDate(data.getSaleDate());
                            setDiscountDepth(ComputeUtil.discountDepth(data.getRegularPrice(), data.getRevenue()));
                            setTransactions(data.getTransactions());
                            setUpt(ComputeUtil.UPT(data.getUnits(), data.getTransactions()));
                        }
                    };
                    return saleAggrData;
            })
            .collect(Collectors.toList());