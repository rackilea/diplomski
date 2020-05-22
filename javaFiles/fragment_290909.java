User { name, type  }  
         // type is perhaps an enum with values such as administrator,
         // manager, seniorManager, executive 

Response { user, decision }
         // decision is an enum "pending", "approved", "rejected"

Role { name, minimumTypeOfUser }
         // first approval can be done by administrators or above
         // second approval by managers or above
         // third approval by executives only

Approval { Role, Response }


ThingToBeApproved { detalsOfWhatNeedsApproving, approvalList<Approval> }
          // when you set up the approval list you specify each
          // approval role and then select a user whose type matches
          // the role.