Map<BgwContract, List<Fee>> bgwContractFeeMap = bgwContractList
            .stream()
            .filter(bgwContract -> !bgwContract.getStatus().equals(BgwContractStatus.CLOSED))
            .filter(bgwContract -> availableIbans.contains(bgwContract.getFeeAccount()))
            .collect(
                    Collectors.toMap(Function.identity(),
                                     bgwContractFeeService::getContractMonthlyFees,
                                     (l1,l2)->{
                                         l1.addAll(l2);
                                         return l1;
                                      })
            );