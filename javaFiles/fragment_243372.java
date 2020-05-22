-----------------------------------com.example.Account.java-----------------------------------

            package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class AccountDTO {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("accounts")
        @Expose
        private List<EmailDTO> emails = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public List<EmailDTO> getEmails() {
            return emails;
        }

        public void setAccounts(List<EmailDTO> emails) {
            this.emails = emails;
        }
    }

-----------------------------------com.example.Account_.java-----------------------------------

            package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class EmailDTO {

        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("email_platform")
        @Expose
        private List<String> emailPlatform = null;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<String> getEmailPlatform() {
            return emailPlatform;
        }

        public void setEmailPlatform(List<String> emailPlatform) {
            this.emailPlatform = emailPlatform;
        }

    }
-----------------------------------com.example.Response.java-----------------------------------

            package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Response {
        @SerializedName("account")
        @Expose
        private AccountDTO account;

        public AccountDTO getAccount() {
            return account;
        }

        public void setAccount(AccountDTO account) {
            this.account = account;
        }
    }