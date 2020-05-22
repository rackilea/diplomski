create table if not exists thread_answer(
    answer_id INT NOT NULL auto_increment,
    question_id INT NOT NULL references thread_question(question_id),
    person_name_answer VARCHAR(100) NOT NULL,
    answer VARCHAR(100000) NOT NULL,
    answer_dateTime VARCHAR(100) NOT NULL,
    PRIMARY KEY(answer_id)
);