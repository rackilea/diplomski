Future<?> recalculatePayrollEntry(PayrollEntry pe) {
    // Calculate Payroll Entry;
    pe.setEarningsEntries(newEarnings);
    return new AsyncResult<Object>(null); // just something symbolic
}

// Usage:
List<Future<?>> results = new ArrayList<>();
for (PayrollEntry pe : payroll.getEntries()) {
    results.add(recalculatePayrollEntry(pe));
}
for (Future<?> result : results){
    result.get(); // await completion
}

CalculateTotals(payroll);