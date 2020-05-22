ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
...
HashMap<String, ArrayList<Voucher>> groups = new HashMap<String, ArrayList<Voucher>>();
for (Voucher v : vouchers) {
    if (groups.containsKey(v.getOriginShippingLocationCode())) {
        groups.get(v.getOriginShippingLocationCode()).add(v);
    } else {
        groups.put(v.getOriginShippingLocationCode(), new ArrayList<Voucher>(Arrays.asList(new Voucher[] { v })));
    }
}