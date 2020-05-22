@Override 
public Observable<List<Assignment>> query(Specification specification) {
    return Observable.create(subscriber -> {
            final SqlSpecification sqlSpecification = (SqlSpecification) specification;

            final SQLiteDatabase database = mOpenHelper.getReadableDatabase();
            final List<Assignment> assignments = new ArrayList<>();

            try { 
                final Cursor cursor = database.rawQuery(sqlSpecification.toSqlQuery(), new String[]{});

                for (int i = 0, size = cursor.getCount(); i < size; i++) {
                    cursor.moveToPosition(i);

                    assignments.add(mToAssignmentMapper.map(cursor));
                } 

                subscriber.onNext(assignments);

                cursor.close();
            } finally { 
                database.close();
                subscriber.onCompleted(); 
            } 
    }
}