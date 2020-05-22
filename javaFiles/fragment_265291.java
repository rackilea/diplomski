create table "PUBLIC"."T_BOOK"(
  "ID" int not null,
  "AUTHOR_ID" int not null,
  "CO_AUTHOR_ID" int null,
  "DETAILS_ID" int null,
  "TITLE" varchar(400) not null,
  "PUBLISHED_IN" int not null,
  "LANGUAGE_ID" int not null,
  "CONTENT_TEXT" clob null,
  "CONTENT_PDF" blob null,
  "REC_VERSION" int null,
  "REC_TIMESTAMP" timestamp null,
  constraint "PK_T_BOOK"
    primary key ("ID"),
  constraint "FK_T_BOOK_AUTHOR_ID"
    foreign key ("AUTHOR_ID")
    references "PUBLIC"."T_AUTHOR" ("ID"),
  constraint "FK_T_BOOK_CO_AUTHOR_ID"
    foreign key ("CO_AUTHOR_ID")
    references "PUBLIC"."T_AUTHOR" ("ID"),
  constraint "FK_T_BOOK_LANGUAGE_ID"
    foreign key ("LANGUAGE_ID")
    references "PUBLIC"."T_LANGUAGE" ("ID")
);