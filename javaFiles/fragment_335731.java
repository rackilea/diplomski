public class DeleteUserFragment extends Fragment {
   private DeleteCompletedCallback deleteCompletedCallback;//Creating A Callback For Interaction With Activity In The Fragtment.

   @Override
   public void onAttach(Activity activity) {
     super.onAttach(activity);
     deleteCompletedCallback = (DeleteCompletedCallback) activity;
   }

   public interface DeleteCompletedCallback{//Making The Interface To Be Implemented In The Activity.
       void onDeleteCompleted();
   }        
  }
}