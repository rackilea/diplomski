Employee e= new Employee();
for (Event event: events) {
    switch (event.getType()) {
        case EMP_ID:
            e.setEmployeeId(event.getvalue());
            break;
        case EMP_NAME:
            e.setEmployeeName(event.getvalue());
            break;
        ....
    }
}