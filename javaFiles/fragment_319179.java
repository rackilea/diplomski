int index = 1;
while (rs.next()) {
    ...

    timetable.modules.put(index, module);
    index++;

    ...
}