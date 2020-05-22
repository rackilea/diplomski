List<student> studentList  = studentRepository.findById(idval);

IntStream.range(0, adpodList.size()).forEach(index -> {
            if(index == 0)
            {
 st.setStartTime(studentList.get(index).getStartTime()); // fetch from 1st item
 st.setEndTime(studentList.get(index).getEndTime()); // fetch from 1st item
}
else if(index == 1)
            {
st.setNextStartTime(studentList.get(index).getStartTime()); // fetch from 2nd item
}});