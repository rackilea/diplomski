CREATE TABLE password_reset_tokens (
  -- columns declaration here
  user_id INT(11) NOT NULL,
  CONSTRAINT FK_PASSWORD_RESET_TOKEN_USER_ID
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);