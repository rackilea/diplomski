package models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "campaign_item_slots")
public class CampaignItemSlot implements Serializable{
    
    @EmbeddedId
    private CampaignItemSlotPk campaignItemSlotPk;    

    @MapsId("advert_slot_id")
    @JoinColumns({
       @JoinColumn(name="advert_slot_id", referencedColumnName="id"),
    })
    @ManyToOne AdvertSlot advertSlot;
    
    @MapsId("campaign_item_id")
    @JoinColumns({
       @JoinColumn(name="campaign_item_id", referencedColumnName="id"),
    })
    @ManyToOne CampaignItem campaignItem;    
    
    private boolean active;
    
    private Timestamp date_created;

    private Timestamp date_updated;

 public CampaignItemSlot() {
  super();
  // TODO Auto-generated constructor stub
 }

 public CampaignItemSlotPk getCampaignItemSlotPk() {
  return campaignItemSlotPk;
 }

 public void setCampaignItemSlotPk(CampaignItemSlotPk campaignItemSlotPk) {
  this.campaignItemSlotPk = campaignItemSlotPk;
 }

 public boolean isActive() {
  return active;
 }

 public void setActive(boolean active) {
  this.active = active;
 }

 public Timestamp getDate_created() {
  return date_created;
 }

 public void setDate_created(Timestamp date_created) {
  this.date_created = date_created;
 }

 public Timestamp getDate_updated() {
  return date_updated;
 }

 public void setDate_updated(Timestamp date_updated) {
  this.date_updated = date_updated;
 }

 public AdvertSlot getAdvertSlot() {
  return advertSlot;
 }

 public void setAdvertSlot(AdvertSlot advertSlot) {
  this.advertSlot = advertSlot;
 }

 public CampaignItem getCampaignItem() {
  return campaignItem;
 }

 public void setCampaignItem(CampaignItem campaignItem) {
  this.campaignItem = campaignItem;
 }
 
}