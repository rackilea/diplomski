JSONObject jsonObj= new JSONObject(userDetail);
    JSONArray jsonArray = jsonObj.getJSONArray("MemberList");

                    for (int i = 0; i < jsonArray.length(); i++) {
                    member = new Member();
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    member.MemberId = jsonObject.optInt("MemberId");
                    member.MemberTypeId = jsonObject.optInt("MemberTypeId");
                    member.FirmTypeId = jsonObject.optInt("FirmTypeId");
                    member.IsRegistered = jsonObject.optInt("IsRegistered");

                    member.MemberUserName = jsonObject.optString("MemberUserName");
                    member.MemberName = jsonObject.optString("MemberName");
                    member.UpdateDate = jsonObject.optString("UpdateDate");
                    member.LastLoginDate = jsonObject.optString("LastLoginDate");
                    member.FirmName = jsonObject.optString("FirmName");
                    member.FirmOfficialName = jsonObject.optString("FirmOfficialName");
                    member.FirmRowGuid = jsonObject.optString("FirmRowGuid");
                    member.MemberRowGuid = jsonObject.optString("MemberRowGuid");
                    member.AuthToken = jsonObject.optString("AuthToken");
                }