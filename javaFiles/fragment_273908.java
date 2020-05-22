package models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
public class CampaignItemSlotPk implements Serializable{
    
    @Column(name="campaign_item_id")
    private long campaignItem;

    @Column(name="advert_slot_id")
    private long advertSlot;

 public CampaignItemSlotPk() {
  // TODO Auto-generated constructor stub
 }

 public long getCampaignItem() {
  return campaignItem;
 }

 public void setCampaignItem(long campaignItem) {
  this.campaignItem = campaignItem;
 }

 public long getAdvertSlot() {
  return advertSlot;
 }

 public void setAdvertSlot(long advertSlot) {
  this.advertSlot = advertSlot;
 }


}