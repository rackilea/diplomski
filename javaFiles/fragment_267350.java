DROP TABLE IF EXISTS student;

CREATE TABLE student
(id INT NOT NULL aUTO_INCREMENT PRIMARY KEY
,name VARCHAR(12) NOT NULL
);

INSERT INTO student VALUES
(1,'Peter'),
(2,'David'),
(3,'Mark'),
(4,'Peter'),
(5,'Brian');


DROP TABLE IF EXISTS student_skill;

CREATE TABLE student_skill
(id_student INT NOT NULL
,skill VARCHAR(20) NOT NULL
,value INT NOT NULL 
,PRIMARY KEY(id_student,skill)
);

INSERT INTO student_skill VALUES
(1,'height',180),
(1,'weight',75),
(2,'height',170),
(3,'height',180),
(4,'height',170),
(4,'weight',75),
(5,'height',180),
(5,'weight',75);