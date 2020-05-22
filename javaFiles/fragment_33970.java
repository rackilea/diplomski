create table USER_INFO (
  USER_ID int not null primary key,
  USER_NAME varchar(16),
  PASSWORD varchar(64)
);

create table CONNECTION_TYPE (
  CONNECTION_TYPE_ID int not null primary key,
  CONNECTION_TYPE_NAME varchar(16) not null,
  CONNECTION_TYPE_DESCRIPTION varchar(128),
  unique (CONNECTION_TYPE_NAME)
);

create table CONNECTION (
  CONNECTION_ID int not null primary key,
  CONNECTION_TYPE_ID int,
  RELATED_USER_ID int,
  RELATING_USER_ID int,
  foreign key (CONNECTION_TYPE_ID) references CONNECTION_TYPE(CONNECTION_TYPE_ID),
  foreign key (RELATED_USER_ID) references USER_INFO(USER_ID),
  foreign key (RELATING_USER_ID) references USER_INFO(USER_ID)