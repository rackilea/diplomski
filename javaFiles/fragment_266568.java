class User {
  int userId
  ...
}

<insert id="addUser" useGeneratedKeys="true" keyColumn="user_id" keyProperty="userId">
  INSERT INTO user(login, name,...) VALUES(#{login}, #{name},...
</insert>